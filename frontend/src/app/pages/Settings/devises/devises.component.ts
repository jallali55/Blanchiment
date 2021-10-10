import { Component, OnInit } from '@angular/core';
import { DeviseService } from '../../../service/devise/devise.service';

@Component({
  selector: 'ngx-devises',
  templateUrl: './devises.component.html',
  styleUrls: ['./devises.component.scss']
})
export class DevisesComponent implements OnInit {

  devises;
  from;
  to;
  quantite;
  res=""
  dtOptions: DataTables.Settings = {};

  constructor(private serviceDevise:DeviseService) { }

  ngOnInit(): void {
   

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
         
    this.serviceDevise.getAll().subscribe(data1=>{
      this.devises=data1;
    })
  }

  convert(){
this.serviceDevise.convert(this.from,this.to,this.quantite).subscribe((data:any)=>{
  this.res=this.quantite+" "+this.from+" = "+data.totalCalculatedAmmount+this.to
})

  }

}
