import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { OperationDto } from '../../../../Model/OerationDto';
import { CompteService } from '../../../../service/compte/compte.service';
import { DeviseService } from '../../../../service/devise/devise.service';
import { OperationService } from '../../../../service/operation/operation.service';

@Component({
  selector: 'ngx-new-operation',
  templateUrl: './new-operation.component.html',
  styleUrls: ['./new-operation.component.scss']
})
export class NewOperationComponent implements OnInit {
  operationForm: FormGroup;
  operations;
  comptes;
  devises
  submited=false;
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


  constructor(private router:Router,private serviceOperation:OperationService,private serviceCompte:CompteService,
    private serviceDevise:DeviseService,private _formBuilder: FormBuilder,private toastrService: NbToastrService) { }

  ngOnInit(): void {
    this.serviceOperation.getAll().subscribe(data=>{
      this.operations=data;
    })
    this.serviceCompte.getValid().subscribe(data=>{
      this.comptes=data;
    })
    this.serviceDevise.getAll().subscribe(data=>{
      this.devises=data
    })
    this.operationForm = this._formBuilder.group({
      compte_id:['',Validators.required],
      montant:['',Validators.required],
      type:['',Validators.required],
    })
  }

  get f() { return this.operationForm.controls; }

  addOperation(){
    this.submited=true
    if(this.operationForm.valid){
      let operationDto=new OperationDto(this.operationForm.value.montant,this.operationForm.value.compte_id,this.operationForm.value.type)
      this.serviceOperation.save(operationDto).subscribe(()=>{
      })
  
      this.router.navigateByUrl('/pages/operations', { skipLocationChange: true }).then(() => {
        this.router.navigate(['/pages/operations']);
    }); 
  
    this.showToast(this.status, "Operation effectué avec succées", "");
  
  
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
