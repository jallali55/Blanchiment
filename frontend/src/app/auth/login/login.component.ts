import { Component, OnInit } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Inject }  from '@angular/core';
import { LoginService } from '../../service/auth/login.service';
import { User } from '../../Model/user';
import { Router } from '@angular/router';

@Component({
  selector: 'ngx-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email;
  password;
  mode:number=0;
  constructor(@Inject(DOCUMENT) document,private loginService:LoginService,private router :Router) { }

  ngOnInit(): void {
    document.getElementById("nb-global-spinner").style.display='none';
    if(this.loginService.isLoginIn()==true){
     
      this.router.navigate(["pages/dashboard"])
    
  }

  }
  login(){
    let user=new User(this.email,this.password)

    this.loginService.login(user).subscribe(
      resp=>{
        let jwtToken = resp.headers.get('Authorization');
        this.loginService.saveToken(jwtToken);
       this.router.navigate(["pages/dashboard"])
        },
        err => {
          this.mode = 1;
        })
    
  }

}
