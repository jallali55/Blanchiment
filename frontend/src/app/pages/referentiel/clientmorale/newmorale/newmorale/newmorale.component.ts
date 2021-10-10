import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { ClientmoraleDto } from '../../../../../Model/clientmoraledto';
import { ClientmoraleService } from '../../../../../service/clientmorale/clientmorale.service';
import { PaysService } from '../../../../../service/pays/pays.service';

@Component({
  selector: 'ngx-newmorale',
  templateUrl: './newmorale.component.html',
  styleUrls: ['./newmorale.component.scss']
})
export class NewmoraleComponent implements OnInit {

  clientMoraleForm: FormGroup;
  public pays :any
  submited=false;
  unique =true;
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
  constructor(private _formBuilder: FormBuilder,private servicemorale:ClientmoraleService,private router:Router
    ,private servicepays:PaysService,private toastrService: NbToastrService) { }

  ngOnInit(): void {
    this.servicepays.getAll().subscribe(data=>{
      this.pays=data;
    })
    this.clientMoraleForm = this._formBuilder.group({
      raisonSocial:['',Validators.required],
      numeroFiscal:['',Validators.required],
      numeroDocumentFiscal:['',Validators.required],
      formeJuridique:['',Validators.required],
      raisonEconomique:['',Validators.required],
      email:['',[Validators.required, Validators.email]],
      fax:['',Validators.required],
      mobile:['',Validators.required],
      tel:['',Validators.required],
      pays:['',Validators.required]

    });
  }
  get f() { return this.clientMoraleForm.controls; }

  onSubmit(){
    this.submited=true
    if(this.clientMoraleForm.valid){
      let personneMoraledto=new ClientmoraleDto(this.clientMoraleForm.value.pays,this.clientMoraleForm.value.email,this.clientMoraleForm.value.fax ,this.clientMoraleForm.value.mobile ,this.clientMoraleForm.value.tel ,
        this.clientMoraleForm.value.raisonSocial,this.clientMoraleForm.value.numeroFiscal,this.clientMoraleForm.value.numeroDocumentFiscal,this.clientMoraleForm.value.formeJuridique ,this.clientMoraleForm.value.raisonEconomique);
      this.servicemorale.save(personneMoraledto).subscribe(()=>{
        this.router.navigateByUrl('/pages/referentiel/clientmorale', { skipLocationChange: true }).then(() => {
          this.router.navigate(['/pages/referentiel/clientmorale']);
      })
      this.showToast(this.status, "Client morale ajouté avec succées", "");
       },err=>{
         this.unique=false;
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
