import { Component } from '@angular/core';

@Component({
  selector: 'ngx-footer',
  styleUrls: ['./footer.component.scss'],
  template: `
    <span class="created-by">
      Created by   <b><a href="http://www.bfigroupe.com/" target="_blank">BFI GROUPE</a></b> 2021
    </span>
    <div class="socials">
      <a href="https://www.facebook.com/bfigoupe/" target="_blank" class="ion ion-social-facebook"></a>
      <a href="https://twitter.com/bfigroupe?lang=fr" target="_blank" class="ion ion-social-twitter"></a>
      <a href="https://fr.linkedin.com/company/bfi-group" target="_blank" class="ion ion-social-linkedin"></a>
    </div>
  `,
})
export class FooterComponent {
}
