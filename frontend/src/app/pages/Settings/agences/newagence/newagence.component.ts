import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { AgenceDto } from '../../../../Model/agencedto';
import { AgenceService } from '../../../../service/agence/agence.service';
import { PaysService } from '../../../../service/pays/pays.service';

@Component({
  selector: 'ngx-newagence',
  templateUrl: './newagence.component.html',
  styleUrls: ['./newagence.component.scss']
})
export class NewagenceComponent implements OnInit {

  agenceForm: FormGroup;
  submited=false

  config: NbToastrConfig;
  index = 1;
  status: NbComponentStatus = 'success';
  pays;

  types: NbComponentStatus[] = [
    'primary',
    'success',
    'info',
    'warning',
    'danger',
  ];
  constructor(private agenceService:AgenceService,private servicepays:PaysService,private _formBuilder: FormBuilder ,private router:Router,private toastrService: NbToastrService) { }

  ngOnInit(): void {
    this.servicepays.getAll().subscribe(data=>{
      this.pays=data;
    })
    this.agenceForm = this._formBuilder.group({
      adresse:['',Validators.required],
      libcou:['',Validators.required],
      liblon:['',Validators.required],
      code_interne:['',Validators.required],
      pays:['',Validators.required]
    });
  }

  
  get f() { return this.agenceForm.controls; }

  onSubmit(){

    this.submited=true;
    if(this.agenceForm.valid){
      let agence=new AgenceDto(this.agenceForm.value.libcou,this.agenceForm.value.liblon,this.agenceForm.value.adresse,this.agenceForm.value.code_interne,
        this.agenceForm.value.pays)
        console.log(agence)
        this.agenceService.save(agence).subscribe(()=>{
          this.router.navigateByUrl('/pages/agences', { skipLocationChange: true }).then(() => {
            this.router.navigate(['/pages/agences']);
        })
        this.showToast(this.status, "Agence ajouté avec succées", "");
  
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
