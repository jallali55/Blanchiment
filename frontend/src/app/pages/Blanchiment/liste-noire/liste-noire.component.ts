import { Component, OnInit } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { SmartTableData } from '../../../@core/data/smart-table';
import { ListenoireService } from '../../../service/listenoire.service';

@Component({
  selector: 'ngx-liste-noire',
  templateUrl: './liste-noire.component.html',
  styleUrls: ['./liste-noire.component.scss']
})
export class ListeNoireComponent implements OnInit {

  listeNoirs;
  dtOptions: DataTables.Settings = {};

  constructor(private listeNoireService : ListenoireService) {
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
    this.listeNoireService.getListeNoires().subscribe(data=>{
      this.listeNoirs=data
    });
  }

}
