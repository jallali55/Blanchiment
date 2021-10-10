import { Component, OnInit } from '@angular/core';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { CompteService } from '../../service/compte/compte.service';

@Component({
  selector: 'ngx-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.scss']
})
export class CompteComponent implements OnInit {

  public listcomptes;
  dtOptions: DataTables.Settings = {};
  config: NbToastrConfig;
  index = 1;
  status: NbComponentStatus = 'success';
  status1: NbComponentStatus = 'danger';



  types: NbComponentStatus[] = [
    'primary',
    'success',
    'info',
    'warning',
    'danger',
  ];

  constructor(private servicecompte:CompteService,private toastrService: NbToastrService) {
    
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
    this.servicecompte.getAll().subscribe(data=>{
      this.listcomptes=data
    })
  }

  enable(id){
    this.listcomptes=""
    this.servicecompte.enable(id).subscribe(()=>{
      this.servicecompte.getAll().subscribe((data:any)=>{
        this.listcomptes=data
      })
      this.showToast(this.status, "Compte activé", "");

    })
  }
  disable(id){
    this.listcomptes=""
    this.servicecompte.disable(id).subscribe(()=>{
      this.servicecompte.getAll().subscribe((data:any)=>{
        this.listcomptes=data
      })
      this.showToast(this.status1, "Compte désactivé", "");

    })
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
