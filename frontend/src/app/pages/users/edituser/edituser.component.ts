import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbGlobalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { UserDto } from '../../../Model/userdto';
import { UserService } from '../../../service/user/user.service';
@Component({
  selector: 'ngx-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.scss']
})
export class EdituserComponent implements OnInit {

  
  userForm: FormGroup;
  submited=false
  user;


  config: NbToastrConfig;
  index = 1;
  status: NbComponentStatus = 'warning';


  types: NbComponentStatus[] = [
    'primary',
    'success',
    'info',
    'warning',
    'danger',
  ];

  constructor(private activatedRouter: ActivatedRoute,private userService:UserService,private _formBuilder: FormBuilder ,private router:Router,private toastrService: NbToastrService) { }

  ngOnInit(): void {
    
    this.userForm = this._formBuilder.group({
      email:['',[Validators.required,, Validators.email]],
      firstName:['',Validators.required],
      lastName:['',Validators.required],
      phoneNumber:['',Validators.required],
      username:['',[Validators.required,Validators.minLength(4)]],
      authority:['',Validators.required],
    });
    this.userService.get(this.activatedRouter.snapshot.params['id']).subscribe(
      (data:any)=>{
        this.userForm = this._formBuilder.group({
          email:[data.email,[Validators.required,, Validators.email]],
          firstName:[data.firstName,Validators.required],
          lastName:[data.lastName,Validators.required],
          phoneNumber:[data.phoneNumber,Validators.required],
          username:[data.username,[Validators.required,Validators.minLength(4)]],
          authority:[data.authority.id,Validators.required],
        });
        
      }
    )
 
  }

  get f() { return this.userForm.controls; }

  onSubmit(){

    this.submited=true;
    if(this.userForm.valid){
      let user=new UserDto(this.userForm.value.email,this.userForm.value.firstName,this.userForm.value.lastName,this.userForm.value.phoneNumber,
        this.userForm.value.authority,true,this.userForm.value.username,"")
        this.userService.edit(this.activatedRouter.snapshot.params['id'],user).subscribe(()=>{
          this.router.navigateByUrl('/pages/users', { skipLocationChange: true }).then(() => {
            this.router.navigate(['/pages/users']);
        })
        this.showToast(this.status, "Utilisateur modifié avec succées", "");
  
      });
        
    }

  
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
