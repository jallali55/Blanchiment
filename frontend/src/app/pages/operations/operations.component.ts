import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OperationDto } from '../../Model/OerationDto';
import { CompteService } from '../../service/compte/compte.service';
import { DeviseService } from '../../service/devise/devise.service';
import { OperationService } from '../../service/operation/operation.service';

@Component({
  selector: 'ngx-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.scss']
})
export class OperationsComponent implements OnInit {

  operations;
  dtOptions: DataTables.Settings = {};

  constructor(private serviceOperation:OperationService) {
    
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
    this.serviceOperation.getAll().subscribe(data=>{
      this.operations=data;
    })
  }

 

}
