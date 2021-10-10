import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientphysiqueService } from '../../../service/clientphysique.service';

@Component({
  selector: 'ngx-clientphysique',
  templateUrl: './clientphysique.component.html',
  styleUrls: ['./clientphysique.component.scss']
})
export class ClientphysiqueComponent implements OnInit {

  public clientPhysiques;
  dtOptions: DataTables.Settings = {};
  constructor(private service:ClientphysiqueService,private router:Router) {
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
    this.service.getAll().toPromise().then(data=>{
      console.log(data)
    this.clientPhysiques=data;
  })
  }

  edit(id){
    this.router.navigateByUrl('/pages/referentiel/clientphysique/edit/'+id, { skipLocationChange: true }).then(() => {
      this.router.navigate(['/pages/referentiel/clientphysique/edit/'+id]);
  })
  }

}
