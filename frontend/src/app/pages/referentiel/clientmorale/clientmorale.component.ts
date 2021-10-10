import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientmoraleDto } from '../../../Model/clientmoraledto';
import { ClientmoraleService } from '../../../service/clientmorale/clientmorale.service';

@Component({
  selector: 'ngx-clientmorale',
  templateUrl: './clientmorale.component.html',
  styleUrls: ['./clientmorale.component.scss']
})
export class ClientmoraleComponent implements OnInit {
  dtOptions: DataTables.Settings = {};
  public clientMorales;

  constructor(private servicemorale:ClientmoraleService,private router:Router) { 
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
    this.servicemorale.getAll().toPromise().then(data=>{
    this.clientMorales=data;
  })
 
  }

  edit(id){
    this.router.navigateByUrl('/pages/referentiel/clientmorale/edit/'+id, { skipLocationChange: true }).then(() => {
      this.router.navigate(['/pages/referentiel/clientmorale/edit/'+id]);
  })
  }
}
