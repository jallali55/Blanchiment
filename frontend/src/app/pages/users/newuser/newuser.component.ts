import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbGlobalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { UserDto } from '../../../Model/userdto';
import { UserService } from '../../../service/user/user.service';

@Component({
  selector: 'ngx-newuser',
  templateUrl: './newuser.component.html',
  styleUrls: ['./newuser.component.scss']
})
export class NewuserComponent implements OnInit {

  userForm: FormGroup;
  submited=false
  unique=true;

  config: NbToastrConfig;
  index = 1;
  status: NbComponentStatus = 'success';


  types: NbComponentStatus[] = [
    'primary',
    'success',
    'info',
    'warning',
    'danger',
  ];
  constructor(private userService:UserService,private _formBuilder: FormBuilder ,private router:Router,private toastrService: NbToastrService) { }

  ngOnInit(): void {
    this.userForm = this._formBuilder.group({
      email:['',[Validators.required,, Validators.email]],
      firstName:['',Validators.required],
      lastName:['',Validators.required],
      phoneNumber:['',Validators.required],
      isenabled:['',null],
      username:['',[Validators.required,Validators.minLength(4)]],
      password:['',[Validators.required,Validators.minLength(8)]],
      authority:['',Validators.required],
    });
  }

  get f() { return this.userForm.controls; }

  onSubmit(){

    this.submited=true;
    if(this.userForm.valid){
      let user=new UserDto(this.userForm.value.email,this.userForm.value.firstName,this.userForm.value.lastName,this.userForm.value.phoneNumber,
        this.userForm.value.authority,this.userForm.value.isenabled,this.userForm.value.username,this.userForm.value.password)
        this.userService.save(user).subscribe(()=>{
          this.router.navigateByUrl('/pages/users', { skipLocationChange: true }).then(() => {
            this.router.navigate(['/pages/users']);
        })
        this.showToast(this.status, "Utilisateur ajouté avec succées", "");
  
      },err=>{
        this.unique=false
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
