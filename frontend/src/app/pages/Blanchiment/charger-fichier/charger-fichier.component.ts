import { Component, OnInit } from '@angular/core';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { ListenoireService } from '../../../service/listenoire.service';

@Component({
  selector: 'ngx-charger-fichier',
  templateUrl: './charger-fichier.component.html',
  styleUrls: ['./charger-fichier.component.scss']
})
export class ChargerFichierComponent implements OnInit {

  files;
  dtOptions: DataTables.Settings = {};
  selectedFiles: FileList;
  currentFilesUpload:File;
  config: NbToastrConfig;
  index = 1;
  status: NbComponentStatus = 'success';


  types: NbComponentStatus[] = [
    'primary',
    'success',
    'info',
    'warning',
    'danger',
  ];
  constructor(private listeNoireService : ListenoireService,private toastrService: NbToastrService) {
    this.dtOptions = {
      
      
      /* below is the relevant part, e.g. translated to spanish */ 
      language: {
        emptyTable: "Aucune donnée disponible dans le tableau",
        lengthMenu: "Afficher _MENU_ éléments",
        loadingRecords: "Chargement...",
        processing: "Traitement...",
        zeroRecords: "Aucun élément correspondant trouvé",
        paginate: {
            first: "Premier",
            last: "Dernier",
            previous: "Précédent",
            next: "Suiv"
        },
        search: "Chercher:",
        info: "Afficher _START_ à _END_ de _TOTAL_ Elements",
        aria: {
            "sortAscending": ": activer pour trier la colonne par ordre croissant",
            "sortDescending": ": activer pour trier la colonne par ordre décroissant"
        }
      }
        };
   }

  ngOnInit(): void {
    this.listeNoireService.getFiles().subscribe(data=>{
      this.files=data;
    })
  }

  readUrl(event:any) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
  
      reader.onload = (event: ProgressEvent) => {
      }
      this.currentFilesUpload=event.target.files[0];
      reader.readAsDataURL(event.target.files[0]);
    }
  }
  onSubmit(){
    this.listeNoireService.pushFileToStorage(this.currentFilesUpload).subscribe(()=>{
      this.listeNoireService.getFiles().subscribe(data=>{
        this.files=data;
      })
    });
    this.showToast(this.status, "Fichier chargé avec succées", "");

  }

  
  private showToast(type: NbComponentStatus, title: string, body: string) {
    const config = {
      status: type,
      destroyByClick: true,
      duration: 2000,
      hasIcon: true,
      position: NbGlobalPhysicalPosition.TOP_RIGHT,
      preventDuplicates: false,
    };
    const titleContent = title ? ` ${title}` : '';

    this.index += 1;
    this.toastrService.show(
      body,
      `${titleContent}`,
      config);
  }

}
