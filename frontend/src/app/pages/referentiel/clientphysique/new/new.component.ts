import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { ClientphysiqueDto } from '../../../../Model/clientphysiquedto';
import { ClientphysiqueService } from '../../../../service/clientphysique.service';
import { PaysService } from '../../../../service/pays/pays.service';

@Component({
  selector: 'ngx-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.scss']
})
export class NewComponent implements OnInit {

  clientPhysiqueForm: FormGroup;
  public pays :any
  submited=false;
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
  constructor(private _formBuilder: FormBuilder,private serviceclient:ClientphysiqueService,private router:Router
    ,private servicepays:PaysService,private toastrService: NbToastrService) { }

  ngOnInit(): void {
    this.servicepays.getAll().subscribe(data=>{
      this.pays=data;
    })
    this.clientPhysiqueForm = this._formBuilder.group({
      fct:['',Validators.required],
      cin:['',Validators.required],
      birthday:['',Validators.required],
      email:['',[Validators.required, Validators.email]],
      fax:['',Validators.required],
      langue:['',Validators.required],
      mobile:['',Validators.required],
      nom:['',Validators.required],
      prenom:['',Validators.required],
      sexe:['',Validators.required],
      tel:['',Validators.required],
      zip_code:['',Validators.required],
      pays:['',Validators.required]

    });
  }

  get f() { return this.clientPhysiqueForm.controls; }

  onSubmit(){
    this.submited=true;
    if(this.clientPhysiqueForm.valid){
      let personnephysiquedto=new ClientphysiqueDto(this.clientPhysiqueForm.value.pays,this.clientPhysiqueForm.value.email,this.clientPhysiqueForm.value.fax ,this.clientPhysiqueForm.value.mobile ,this.clientPhysiqueForm.value.tel ,
        this.clientPhysiqueForm.value.cin,this.clientPhysiqueForm.value.fct,this.clientPhysiqueForm.value.nom,this.clientPhysiqueForm.value.prenom ,this.clientPhysiqueForm.value.langue ,
        this.clientPhysiqueForm.value.sexe,this.clientPhysiqueForm.value.birthday,this.clientPhysiqueForm.value.zip_code);
      this.serviceclient.save(personnephysiquedto).subscribe(()=>{
        this.router.navigateByUrl('/pages/referentiel/clientphysique', { skipLocationChange: true }).then(() => {
          this.router.navigate(['/pages/referentiel/clientphysique']);
          this.showToast(this.status, "Client physique ajouté avec succées", "");

       });
      
    },
    err=>{
      this.unique=false
    }
    )


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
