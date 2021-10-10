import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { UserService } from '../../../service/user/user.service';

@Component({
  selector: 'ngx-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  users;
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

  constructor(private userService:UserService,private toastrService: NbToastrService,private router:Router) {
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
    this.userService.getAll().subscribe((data:any)=>{
      this.users=data
    })
  }

  enable(id){
    this.users="";
    this.userService.enable(id).subscribe(()=>{
      this.userService.getAll().subscribe((data:any)=>{
        this.users=data
      })
      this.showToast(this.status, "Utilisateur active", "");

    }) 
  }
  disable(id){
    this.users="";
    this.userService.disable(id).subscribe(()=>{
      this.userService.getAll().subscribe((data:any)=>{
        this.users=data
      })
      this.showToast(this.status1, "Utilisateur désactive", "");

    })
    
  }

  edit(id){
    this.router.navigateByUrl('/pages/users/edit/'+id, { skipLocationChange: true }).then(() => {
      this.router.navigate(['/pages/users/edit/'+id]);
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
