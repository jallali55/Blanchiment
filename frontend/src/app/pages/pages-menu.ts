import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Dashboard',
    icon: 'home-outline',
    link: '/pages/dashboard',
    home: true,
  },
 
  {
    title: 'Referentiel',
    icon: 'grid-outline',
    children: [
      {
        title: 'Client Morale',
        link: '/pages/referentiel/clientmorale',
      },
      {
        title: 'Client Physique',
        link: '/pages/referentiel/clientphysique',
      },
    ],
  },
  
  {
    title: 'Compte',
    icon: 'folder-outline',
    link: '/pages/compte',
    
  },
  {
    title: 'Blanchiment',
    icon: 'grid-outline',
    children: [
      {
        title: 'Liste Noire',
        link: '/pages/blanchiment/liste-noire',
      },
    ],
  },
  
  {
    title: 'Operations',
    icon: 'flip-2-outline',
    link:'/pages/operations'
  },
  {
    title: 'Settings',
    icon: 'settings-2-outline',
    children: [
      {
        title: 'Devises',
        icon:'trending-up-outline',
        link: '/pages/devises',
      },
      {
        title: 'Agences',
        icon:'npm-outline',
        link: '/pages/agences',
      },
    ],
  },

];
