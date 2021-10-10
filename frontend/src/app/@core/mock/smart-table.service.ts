import { Injectable } from '@angular/core';
import { SmartTableData } from '../data/smart-table';

@Injectable()
export class SmartTableService extends SmartTableData {

  data = [{
    id: 1,
    firstName: 'Mark',
    lastName: 'Otto',
    Devise: '@mdo',
    Nationalitée: 'mdo@gmail.com',
    age: '28',
  }, {
    id: 2,
    firstName: 'Jacob',
    lastName: 'Thornton',
    Devise: '@fat',
    Nationalitée: 'fat@yandex.ru',
    age: '45',
  }, {
    id: 3,
    firstName: 'Larry',
    lastName: 'Bird',
    Devise: '@twitter',
    Nationalitée: 'twitter@outlook.com',
    age: '18',
  }, {
    id: 4,
    firstName: 'John',
    lastName: 'Snow',
    Devise: '@snow',
    Nationalitée: 'snow@gmail.com',
    age: '20',
  }, {
    id: 5,
    firstName: 'Jack',
    lastName: 'Sparrow',
    Devise: '@jack',
    Nationalitée: 'jack@yandex.ru',
    age: '30',
  }, {
    id: 6,
    firstName: 'Ann',
    lastName: 'Smith',
    Devise: '@ann',
    Nationalitée: 'ann@gmail.com',
    age: '21',
  }, {
    id: 7,
    firstName: 'Barbara',
    lastName: 'Black',
    Devise: '@barbara',
    Nationalitée: 'barbara@yandex.ru',
    age: '43',
  }, {
    id: 8,
    firstName: 'Sevan',
    lastName: 'Bagrat',
    Devise: '@sevan',
    Nationalitée: 'sevan@outlook.com',
    age: '13',
  }, {
    id: 9,
    firstName: 'Ruben',
    lastName: 'Vardan',
    Devise: '@ruben',
    Nationalitée: 'ruben@gmail.com',
    age: '22',
  }, {
    id: 10,
    firstName: 'Karen',
    lastName: 'Sevan',
    Devise: '@karen',
    Nationalitée: 'karen@yandex.ru',
    age: '33',
  }, {
    id: 11,
    firstName: 'Mark',
    lastName: 'Otto',
    Devise: '@mark',
    Nationalitée: 'mark@gmail.com',
    age: '38',
  }, {
    id: 12,
    firstName: 'Jacob',
    lastName: 'Thornton',
    Devise: '@jacob',
    Nationalitée: 'jacob@yandex.ru',
    age: '48',
  }, {
    id: 13,
    firstName: 'Haik',
    lastName: 'Hakob',
    Devise: '@haik',
    Nationalitée: 'haik@outlook.com',
    age: '48',
  }, {
    id: 14,
    firstName: 'Garegin',
    lastName: 'Jirair',
    Devise: '@garegin',
    Nationalitée: 'garegin@gmail.com',
    age: '40',
  }, {
    id: 15,
    firstName: 'Krikor',
    lastName: 'Bedros',
    Devise: '@krikor',
    Nationalitée: 'krikor@yandex.ru',
    age: '32',
  }, {
    'id': 16,
    'firstName': 'Francisca',
    'lastName': 'Brady',
    'Devise': '@Gibson',
    'Nationalitée': 'franciscagibson@comtours.com',
    'age': 11,
  }, {
    'id': 17,
    'firstName': 'Tillman',
    'lastName': 'Figueroa',
    'Devise': '@Snow',
    'Nationalitée': 'tillmansnow@comtours.com',
    'age': 34,
  }, {
    'id': 18,
    'firstName': 'Jimenez',
    'lastName': 'Morris',
    'Devise': '@Bryant',
    'Nationalitée': 'jimenezbryant@comtours.com',
    'age': 45,
  }, {
    'id': 19,
    'firstName': 'Sandoval',
    'lastName': 'Jacobson',
    'Devise': '@Mcbride',
    'Nationalitée': 'sandovalmcbride@comtours.com',
    'age': 32,
  }, {
    'id': 20,
    'firstName': 'Griffin',
    'lastName': 'Torres',
    'Devise': '@Charles',
    'Nationalitée': 'griffincharles@comtours.com',
    'age': 19,
  }, {
    'id': 21,
    'firstName': 'Cora',
    'lastName': 'Parker',
    'Devise': '@Caldwell',
    'Nationalitée': 'coracaldwell@comtours.com',
    'age': 27,
  }, {
    'id': 22,
    'firstName': 'Cindy',
    'lastName': 'Bond',
    'Devise': '@Velez',
    'Nationalitée': 'cindyvelez@comtours.com',
    'age': 24,
  }, {
    'id': 23,
    'firstName': 'Frieda',
    'lastName': 'Tyson',
    'Devise': '@Craig',
    'Nationalitée': 'friedacraig@comtours.com',
    'age': 45,
  }, {
    'id': 24,
    'firstName': 'Cote',
    'lastName': 'Holcomb',
    'Devise': '@Rowe',
    'Nationalitée': 'coterowe@comtours.com',
    'age': 20,
  }, {
    'id': 25,
    'firstName': 'Trujillo',
    'lastName': 'Mejia',
    'Devise': '@Valenzuela',
    'Nationalitée': 'trujillovalenzuela@comtours.com',
    'age': 16,
  }, {
    'id': 26,
    'firstName': 'Pruitt',
    'lastName': 'Shepard',
    'Devise': '@Sloan',
    'Nationalitée': 'pruittsloan@comtours.com',
    'age': 44,
  }, {
    'id': 27,
    'firstName': 'Sutton',
    'lastName': 'Ortega',
    'Devise': '@Black',
    'Nationalitée': 'suttonblack@comtours.com',
    'age': 42,
  }, {
    'id': 28,
    'firstName': 'Marion',
    'lastName': 'Heath',
    'Devise': '@Espinoza',
    'Nationalitée': 'marionespinoza@comtours.com',
    'age': 47,
  }, {
    'id': 29,
    'firstName': 'Newman',
    'lastName': 'Hicks',
    'Devise': '@Keith',
    'Nationalitée': 'newmankeith@comtours.com',
    'age': 15,
  }, {
    'id': 30,
    'firstName': 'Boyle',
    'lastName': 'Larson',
    'Devise': '@Summers',
    'Nationalitée': 'boylesummers@comtours.com',
    'age': 32,
  }, {
    'id': 31,
    'firstName': 'Haynes',
    'lastName': 'Vinson',
    'Devise': '@Mckenzie',
    'Nationalitée': 'haynesmckenzie@comtours.com',
    'age': 15,
  }, {
    'id': 32,
    'firstName': 'Miller',
    'lastName': 'Acosta',
    'Devise': '@Young',
    'Nationalitée': 'milleryoung@comtours.com',
    'age': 55,
  }, {
    'id': 33,
    'firstName': 'Johnston',
    'lastName': 'Brown',
    'Devise': '@Knight',
    'Nationalitée': 'johnstonknight@comtours.com',
    'age': 29,
  }, {
    'id': 34,
    'firstName': 'Lena',
    'lastName': 'Pitts',
    'Devise': '@Forbes',
    'Nationalitée': 'lenaforbes@comtours.com',
    'age': 25,
  }, {
    'id': 35,
    'firstName': 'Terrie',
    'lastName': 'Kennedy',
    'Devise': '@Branch',
    'Nationalitée': 'terriebranch@comtours.com',
    'age': 37,
  }, {
    'id': 36,
    'firstName': 'Louise',
    'lastName': 'Aguirre',
    'Devise': '@Kirby',
    'Nationalitée': 'louisekirby@comtours.com',
    'age': 44,
  }, {
    'id': 37,
    'firstName': 'David',
    'lastName': 'Patton',
    'Devise': '@Sanders',
    'Nationalitée': 'davidsanders@comtours.com',
    'age': 26,
  }, {
    'id': 38,
    'firstName': 'Holden',
    'lastName': 'Barlow',
    'Devise': '@Mckinney',
    'Nationalitée': 'holdenmckinney@comtours.com',
    'age': 11,
  }, {
    'id': 39,
    'firstName': 'Baker',
    'lastName': 'Rivera',
    'Devise': '@Montoya',
    'Nationalitée': 'bakermontoya@comtours.com',
    'age': 47,
  }, {
    'id': 40,
    'firstName': 'Belinda',
    'lastName': 'Lloyd',
    'Devise': '@Calderon',
    'Nationalitée': 'belindacalderon@comtours.com',
    'age': 21,
  }, {
    'id': 41,
    'firstName': 'Pearson',
    'lastName': 'Patrick',
    'Devise': '@Clements',
    'Nationalitée': 'pearsonclements@comtours.com',
    'age': 42,
  }, {
    'id': 42,
    'firstName': 'Alyce',
    'lastName': 'Mckee',
    'Devise': '@Daugherty',
    'Nationalitée': 'alycedaugherty@comtours.com',
    'age': 55,
  }, {
    'id': 43,
    'firstName': 'Valencia',
    'lastName': 'Spence',
    'Devise': '@Olsen',
    'Nationalitée': 'valenciaolsen@comtours.com',
    'age': 20,
  }, {
    'id': 44,
    'firstName': 'Leach',
    'lastName': 'Holcomb',
    'Devise': '@Humphrey',
    'Nationalitée': 'leachhumphrey@comtours.com',
    'age': 28,
  }, {
    'id': 45,
    'firstName': 'Moss',
    'lastName': 'Baxter',
    'Devise': '@Fitzpatrick',
    'Nationalitée': 'mossfitzpatrick@comtours.com',
    'age': 51,
  }, {
    'id': 46,
    'firstName': 'Jeanne',
    'lastName': 'Cooke',
    'Devise': '@Ward',
    'Nationalitée': 'jeanneward@comtours.com',
    'age': 59,
  }, {
    'id': 47,
    'firstName': 'Wilma',
    'lastName': 'Briggs',
    'Devise': '@Kidd',
    'Nationalitée': 'wilmakidd@comtours.com',
    'age': 53,
  }, {
    'id': 48,
    'firstName': 'Beatrice',
    'lastName': 'Perry',
    'Devise': '@Gilbert',
    'Nationalitée': 'beatricegilbert@comtours.com',
    'age': 39,
  }, {
    'id': 49,
    'firstName': 'Whitaker',
    'lastName': 'Hyde',
    'Devise': '@Mcdonald',
    'Nationalitée': 'whitakermcdonald@comtours.com',
    'age': 35,
  }, {
    'id': 50,
    'firstName': 'Rebekah',
    'lastName': 'Duran',
    'Devise': '@Gross',
    'Nationalitée': 'rebekahgross@comtours.com',
    'age': 40,
  }, {
    'id': 51,
    'firstName': 'Earline',
    'lastName': 'Mayer',
    'Devise': '@Woodward',
    'Nationalitée': 'earlinewoodward@comtours.com',
    'age': 52,
  }, {
    'id': 52,
    'firstName': 'Moran',
    'lastName': 'Baxter',
    'Devise': '@Johns',
    'Nationalitée': 'moranjohns@comtours.com',
    'age': 20,
  }, {
    'id': 53,
    'firstName': 'Nanette',
    'lastName': 'Hubbard',
    'Devise': '@Cooke',
    'Nationalitée': 'nanettecooke@comtours.com',
    'age': 55,
  }, {
    'id': 54,
    'firstName': 'Dalton',
    'lastName': 'Walker',
    'Devise': '@Hendricks',
    'Nationalitée': 'daltonhendricks@comtours.com',
    'age': 25,
  }, {
    'id': 55,
    'firstName': 'Bennett',
    'lastName': 'Blake',
    'Devise': '@Pena',
    'Nationalitée': 'bennettpena@comtours.com',
    'age': 13,
  }, {
    'id': 56,
    'firstName': 'Kellie',
    'lastName': 'Horton',
    'Devise': '@Weiss',
    'Nationalitée': 'kellieweiss@comtours.com',
    'age': 48,
  }, {
    'id': 57,
    'firstName': 'Hobbs',
    'lastName': 'Talley',
    'Devise': '@Sanford',
    'Nationalitée': 'hobbssanford@comtours.com',
    'age': 28,
  }, {
    'id': 58,
    'firstName': 'Mcguire',
    'lastName': 'Donaldson',
    'Devise': '@Roman',
    'Nationalitée': 'mcguireroman@comtours.com',
    'age': 38,
  }, {
    'id': 59,
    'firstName': 'Rodriquez',
    'lastName': 'Saunders',
    'Devise': '@Harper',
    'Nationalitée': 'rodriquezharper@comtours.com',
    'age': 20,
  }, {
    'id': 60,
    'firstName': 'Lou',
    'lastName': 'Conner',
    'Devise': '@Sanchez',
    'Nationalitée': 'lousanchez@comtours.com',
    'age': 16,
  }];

  getData() {
    return this.data;
  }
}
