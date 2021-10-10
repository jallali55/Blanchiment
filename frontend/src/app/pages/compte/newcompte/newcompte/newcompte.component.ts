import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { CompteDto } from '../../../../Model/comptedto';
import { AgenceService } from '../../../../service/agence/agence.service';
import { CompteService } from '../../../../service/compte/compte.service';
import { DeviseService } from '../../../../service/devise/devise.service';
import { TierService } from '../../../../service/tier/tier.service';

@Component({
  selector: 'ngx-newcompte',
  templateUrl: './newcompte.component.html',
  styleUrls: ['./newcompte.component.scss']
})
export class NewcompteComponent implements OnInit {
  compteForm: FormGroup;
  agences:any;
  tiers:any;
  devises:any;
  unique=true;
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
  constructor(private _formBuilder: FormBuilder,private servicecompte:CompteService,private deviseservice:DeviseService,
    private router:Router,private tierservice:TierService,private agenceservice:AgenceService,private toastrService: NbToastrService) { }

  ngOnInit(): void {
    this.deviseservice.getAll().subscribe(data=>{
      this.devises=data;})
    this.agenceservice.getAll().subscribe(data=>{
      this.agences=data;})
      this.tierservice.getAll().subscribe(data=>{
        this.tiers=data;})
    this.compteForm = this._formBuilder.group({
      numcpt:['',[Validators.required,Validators.minLength(6)]],
      typecompte:['',Validators.required],
      Rib:['',[Validators.required,Validators.minLength(13)]],
      solde:['',Validators.required],
      id_agence:['',Validators.required],
      id_tier:['',Validators.required],
      id_devise:['',Validators.required],
      statut:['',Validators.required],
      date_ouverture:['',Validators.required],
    })

  }

  get f() { return this.compteForm.controls; }

  onSubmit(){
    this.submited=true
    if(this.compteForm.valid){
      let compte=new CompteDto(this.compteForm.value.numcpt,this.compteForm.value.typecompte,this.compteForm.value.Rib,this.compteForm.value.solde,
        this.compteForm.value.id_agence,this.compteForm.value.id_tier,this.compteForm.value.id_devise,
        this.compteForm.value.statut,this.compteForm.value.date_ouverture)
        this.servicecompte.save(compte).subscribe(()=>{
          this.router.navigateByUrl('/pages/compte', { skipLocationChange: true }).then(() => {
            this.router.navigate(['/pages/compte']);
          });
          this.showToast(this.status, "Compte ajouté avec succées", "");
  
        },
        err=>{
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
