package com.gestion.blanchiment.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.blanchiment.dto.ClientSuspectDto;
import com.gestion.blanchiment.entities.ClientSuspect;
import com.gestion.blanchiment.entities.Uploadfile;
import com.gestion.blanchiment.repos.ClientSuspectRepository;
import com.gestion.blanchiment.repos.UploadFileRepository;
import com.gestion.blanchiment.service.ClientSuspectService;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/clientsuspect")
public class ClientSuspectRestService {
	@Autowired
	private ClientSuspectRepository LNR;
	@Autowired
	private UploadFileRepository ufr;
	@Autowired
	private ClientSuspectService clientSuspectService;

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = clientSuspectService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	

	@PostMapping(value = "/files")
	public ResponseEntity<Object> fileUploadIdea(@RequestParam("file") MultipartFile file) throws IOException {
		return clientSuspectService.addPictureToEntity(file);
	}
	
	@RequestMapping(value = "/getfiles", method = RequestMethod.GET)
	public List<Uploadfile> getFiles() {
		return ufr.findAll();
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ClientSuspect> getlistenoir() {
		return LNR.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClientSuspect getlistenoirbyid(@PathVariable Integer id) {

		return LNR.findById(id).get();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ClientSuspect savelistenoir(@RequestBody ClientSuspectDto t) {
		return clientSuspectService.postClientSuspect(t);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updatelistenoir(@RequestBody ClientSuspect t, @PathVariable Integer id) {
		t.setId(id);
		LNR.save(t);
		return "liste noir mis a jour";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deletelistenoirbyid(@PathVariable Integer id) {
		LNR.deleteById(id);
		return "liste noir " + id + " suprimé";
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public String deletealllistenoirs() {
		LNR.deleteAll();
		return "tous les listes noirs sont suprimés";
	}

}
