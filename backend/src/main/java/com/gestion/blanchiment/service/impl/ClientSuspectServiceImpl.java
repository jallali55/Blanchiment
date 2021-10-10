package com.gestion.blanchiment.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.blanchiment.dto.ClientSuspectDto;
import com.gestion.blanchiment.entities.ClientSuspect;
import com.gestion.blanchiment.entities.Uploadfile;
import com.gestion.blanchiment.repos.ClientSuspectRepository;
import com.gestion.blanchiment.repos.UploadFileRepository;
import com.gestion.blanchiment.service.ClientSuspectService;
import com.gestion.blanchiment.service.ResponseService;

@Service
public class ClientSuspectServiceImpl implements ClientSuspectService {
	private final Path rootLocation;
	@Autowired
	private ClientSuspectRepository clientSuspectRepository;
	@Autowired
	private ResponseService responseService;
	@Autowired
	private UploadFileRepository uploadFileRepository;

	@Override
	public ClientSuspect postClientSuspect(ClientSuspectDto clientsuspectdto) {
		ClientSuspect clientSuspect = new ClientSuspect();
		if (clientsuspectdto.getId() != null) {
			if (clientSuspectRepository.findById(clientsuspectdto.getId()).isPresent()) {
				clientSuspect = clientSuspectRepository.findById(clientsuspectdto.getId()).get();
			}
		}
		if (clientsuspectdto.getId_operation() != null) {
			if (clientSuspectRepository.findById(clientsuspectdto.getId_operation()).isPresent()) {
				clientSuspect = clientSuspectRepository.findById(clientsuspectdto.getId_operation()).get();
			}

		}
		clientSuspect.setDate_insertion(new Date());
		clientSuspect.setNiveau_risque(clientsuspectdto.getNiveau_risque());
		return clientSuspectRepository.save(clientSuspect);

	}

	@Override
	public ClientSuspect getClientSuspectById(Integer id) {
		do {
			return clientSuspectRepository.findById(id).get();
		} while (clientSuspectRepository.findById(id).isPresent());

	}

	@Override
	public List<ClientSuspect> getAllClientSuspect() {
		return clientSuspectRepository.findAll();
	}

	@Override
	public void DeleteClientSuspectById(Integer id) {
		do {
			clientSuspectRepository.deleteById(id);
		} while (clientSuspectRepository.findById(id).isPresent());

	}

	@Override
	public void DeleteAllClientSuspect() {
		clientSuspectRepository.deleteAll();

	}


    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

	@Override
	public Resource loadAsResource(String filename) {
	    try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new RuntimeException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
	}

	@Override
	public ResponseEntity<Object> addPictureToEntity(MultipartFile file) throws IOException {
		try {
			
			if (file.isEmpty()) {
				throw new RuntimeException("Failed to store empty file " + file.getOriginalFilename());
			}

			excelToClientSuspect(file.getInputStream());
			
			String name = UUID.randomUUID() + "." + this.getExtensionByStringHandling(file.getOriginalFilename()).get();

			Uploadfile uploaded = new Uploadfile();
			uploaded.setName(name);
			uploaded.setUploadDate(new Date());
			Uploadfile u = uploadFileRepository.save(uploaded);
			Files.copy(file.getInputStream(), this.rootLocation.resolve(name));

			return responseService.getResponse(0, "File successfully added", u);

		} catch (IOException e) {
			throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
		}

	}

	@Autowired
	public ClientSuspectServiceImpl() {
		this.rootLocation = Paths.get("upload-dir");
	}

	public Optional<String> getExtensionByStringHandling(String filename) {
		return Optional.ofNullable(filename).filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
	
	  static String SHEET = "Tutorials";

	  public void excelToClientSuspect(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheetAt(0);
		      Iterator<Row> rows = sheet.iterator();


		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        ClientSuspect client = new ClientSuspect();
		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		        	 
		           client.setNumeroFiscal(currentCell.getStringCellValue());
		            break;

		          case 1:
		        	try {	
			            client.setCin(""+(int)currentCell.getNumericCellValue());
					} catch (Exception e) {
						client.setCin("0");
					}  
		            break;

		          case 2:
		            client.setNiveau_risque(currentCell.getStringCellValue());
		            break;

		          default:
		            break;
		          }

		          cellIdx++;
		        }
		        client.setDate_insertion(new Date());
		        Boolean valid=true;
		        for (ClientSuspect par : clientSuspectRepository.findAll()) {
					if(client.getCin().equals(par.getCin())&&client.getNumeroFiscal().equals(par.getNumeroFiscal())
							&&client.getNiveau_risque().equals(par.getNiveau_risque())) {
						valid=false;
					}
					if(client.getCin().equals(par.getCin())&&client.getNumeroFiscal().equals(par.getNumeroFiscal())
							&&!client.getNiveau_risque().equals(par.getNiveau_risque())) {
						client.setId(par.getId());
					}
					
				}
		        if(valid) {
			        clientSuspectRepository.save(client);
		        }
		      }

		      workbook.close();

		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }

}
