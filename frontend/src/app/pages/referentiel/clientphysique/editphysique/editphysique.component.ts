import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { ClientphysiqueDto } from '../../../../Model/clientphysiquedto';
import { ClientphysiqueService } from '../../../../service/clientphysique.service';
import { PaysService } from '../../../../service/pays/pays.service';

@Component({
  selector: 'ngx-editphysique',
  templateUrl: './editphysique.component.html',
  styleUrls: ['./editphysique.component.scss']
})
export class EditphysiqueComponent implements OnInit {

  clientPhysiqueForm: FormGroup;
  public pays :any
  submited=false;
  

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
  constructor(private activatedRouter: ActivatedRoute,private _formBuilder: FormBuilder,private serviceclient:ClientphysiqueService,
    private router:Router,private servicepays:PaysService,private toastrService: NbToastrService) { }

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

    this.serviceclient.get(this.activatedRouter.snapshot.params['id']).subscribe(
      (data:any)=>{
        this.clientPhysiqueForm = this._formBuilder.group({
          fct:[data.fct,Validators.required],
          cin:[data.cin,Validators.required],
          birthday:[data.birthday,Validators.required],
          email:[data.email,[Validators.required, Validators.email]],
          fax:[data.fax,Validators.required],
          langue:[data.langue,Validators.required],
          mobile:[data.mobile,Validators.required],
          nom:[data.nom,Validators.required],
          prenom:[data.prenom,Validators.required],
          sexe:[data.sexe,Validators.required],
          tel:[data.tel,Validators.required],
          zip_code:[data.zip_code,Validators.required],
          pays:[data.pays.id,Validators.required]
    
        });
        
      }
    )
  }
  get f() { return this.clientPhysiqueForm.controls; }

  onSubmit(){
    this.submited=true;

    if(this.clientPhysiqueForm.valid){
      let personnephysiquedto=new ClientphysiqueDto(this.clientPhysiqueForm.value.pays,this.clientPhysiqueForm.value.email,this.clientPhysiqueForm.value.fax ,this.clientPhysiqueForm.value.mobile ,this.clientPhysiqueForm.value.tel ,
        this.clientPhysiqueForm.value.cin,this.clientPhysiqueForm.value.fct,this.clientPhysiqueForm.value.nom,this.clientPhysiqueForm.value.prenom ,this.clientPhysiqueForm.value.langue ,
        this.clientPhysiqueForm.value.sexe,this.clientPhysiqueForm.value.birthday,this.clientPhysiqueForm.value.zip_code);
      this.serviceclient.edit(this.activatedRouter.snapshot.params['id'],personnephysiquedto).subscribe(()=>{
        this.router.navigateByUrl('/pages/referentiel/clientphysique', { skipLocationChange: true }).then(() => {
          this.router.navigate(['/pages/referentiel/clientphysique']);
      })
      });

      this.showToast(this.status, "Client physique modifié avec succées", "");

     
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
