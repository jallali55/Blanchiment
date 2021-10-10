import { Component, OnInit } from '@angular/core';
import { DeviseService } from '../../../service/devise/devise.service';
import { PaysService } from '../../../service/pays/pays.service';
import { findFlagUrlByCountry } from "country-flags-svg";
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';

@Component({
  selector: 'ngx-pays',
  templateUrl: './pays.component.html',
  styleUrls: ['./pays.component.scss']
})
export class PaysComponent implements OnInit {
pays;
devises;
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

  constructor(private servicePays:PaysService,private serviceDevise:DeviseService,private toastrService: NbToastrService) { 
  
  }

  ngOnInit(): void {
  
    this.servicePays.getAll().subscribe(data=>{
      this.pays=data;
    })
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

  enable(id){
    this.pays=""
    this.servicePays.nondouteux(id).subscribe(()=>{
      this.servicePays.getAll().subscribe((data:any)=>{
        this.pays=data
      })

      this.showToast(this.status, "cet pays est non plus douteux", "");

    })
  }
  disable(id){
    this.pays=""
    this.servicePays.douteux(id).subscribe(()=>{
      this.servicePays.getAll().subscribe((data:any)=>{
        this.pays=data
      })
    this.showToast(this.status1, "cet pays est maintenant douteux", "");
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

    
  