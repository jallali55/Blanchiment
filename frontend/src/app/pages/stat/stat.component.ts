import { Component, OnInit } from '@angular/core';
import { DeviseService } from '../../service/devise/devise.service';
import { PaysService } from '../../service/pays/pays.service';
import { UserService } from '../../service/user/user.service';

@Component({
  selector: 'ngx-stat',
  templateUrl: './stat.component.html',
  styleUrls: ['./stat.component.scss']
})
export class StatComponent implements OnInit {

  stat
  devises;
  pays;
  from;
  to;
  quantite;
  res=""
  dtOptions: DataTables.Settings = {};
   type = 'PieChart';
   comptestat ;
   tierstat ;
   nbtier;
   nbcompte;
   nbsuspect;
  nbuser;
  constructor(private serviceDevise:DeviseService,private userService:UserService,private servicePays:PaysService) { }

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
    this.userService.getStat().subscribe((data:any)=>{
      this.comptestat = [
        ['Actif',data.nbcompteactif],
        ['Inactif', data.nbcompteinactif],
     ];
     this.nbsuspect=data.nbsuspect;
     this.nbcompte=data.nbcompte
     this.tierstat = [
      ['Client Morale',data.nbmoral],
      ['Client Physique', data.nbphysique],
   ];
   this.nbtier=data.nbtier
   this.nbuser=data.nbuser
    })
    this.serviceDevise.getAll().subscribe(data1=>{
      this.devises=data1;
    })
    this.servicePays.getAll().subscribe(data=>{
      this.pays=data;
    })
   
  }

  convert(){
    this.serviceDevise.convert(this.from,this.to,this.quantite).subscribe((data:any)=>{
      this.res=this.quantite+" "+this.from+" = "+data.totalCalculatedAmmount+this.to
    })
    }

}
