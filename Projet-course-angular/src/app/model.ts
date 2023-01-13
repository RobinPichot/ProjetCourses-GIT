export abstract class Compte{
    id : number;
    nom : string;
    prenom: string;
    mail: string;
    mdp: string;
    adresse : Adresse ;


    constructor(id?:number, nom?:string, prenom?:string, mail?:string, mdp?:string, adresse?:Adresse){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.mail=mail;
        this.mdp=mdp;
        this.adresse=adresse;
    }}


export class Adresse {
    numero: number;
    rue: string;
    postal: string;
    ville:string;

    constructor(numero?:number, rue?: string, postal?: string,ville?:string) {
        this.numero = numero;
        this.rue = rue;
        this.postal = postal;
        this.ville = ville;
    }
}

export class Client extends Compte {
    commande: Commande;

    constructor(id?:number,nom?:string,prenom?:string,mail?:string,mdp?:string,adresse?:Adresse,commande?:Commande) {
        super(id,nom,prenom,mail,mdp,adresse);
        this.commande = commande;
    }
}

export class Commande {
    id:number;
    livree:boolean;
    numeroCommande:number;
    date:string;
    payee:boolean;
    paniers:Array<Panier>=new Array<Panier>();

    constructor(id?:number,livree?:boolean,numeroCommande?:number,date?:string,payee?:boolean,paniers?:Array<Panier>) {
        this.id = id;
        this.livree = livree;
        this.numeroCommande = numeroCommande;
        this.date = date;
        this.payee = payee;
        this.paniers = paniers;
    }
}

export class Evaluation{
    id : number;
    note : number;
    description: string;
    commande: Commande;
    commandeR: Commande;



    constructor(id?:number, note?:number, description?:string, commande?:Commande, commandeR?:Commande){
        this.id=id;
        this.note=note;
        this.description=description;
        this.commande=commande;
        this.commandeR=commandeR;
    }
}

export class Panier{

    id:number;
    plat: Plat;
    quantite:number;
    commande: Commande;
  
    constructor(id?:number, plat?:Plat,quantite?: number,commande?:Commande){
  
  this.id=id;
  this.plat=plat;
  this.quantite=quantite;
  this.commande=commande;
  }
}

export class Plat{
    id:number;
    nom:String;
    prix:number;
    description:String;
    restaurant:Restaurant;
    panier:Panier;
  
  constructor(id?:number,nom?:String,prix?:number,description?:String,restaurant?:Restaurant,panier?:Panier){
  this.id=id;
  this.nom=nom;
  this.prix=prix;
  this.description=description;
  this.restaurant=restaurant;
  this.panier=panier;
  }
}

export enum MoyPayement {

    CB,Paypal,ApplePay,GooglePay,TicketsResto 
}

export class Livreur extends Compte{

    commande : Array<Commande> = new Array<Commande>();


    constructor(id?:number, nom?:string, prenom?:string, mail?:string, mdp?:string, adresse?:string, commande?:Array<Commande> ){
        super(id, prenom, mail, mdp, adresse)
        this.commande=commande;
    }
}

export class Restaurant {
    id: number;
    nom: string;
    ouvert : boolean;
    notation: number;
descriptionRestaurant: string;
menu: Array<Plat>= new Array<Plat>();
commandes: Array<Commande>= new Array<Commande>();

    constructor(id?:number, nom?: string, ouvert?: boolean, notation?: number, descriptionRestaurant?: string, menu?:Array<Plat>) {
        this.id = id;
        this.ouvert = ouvert;
        this.notation = notation;
        this.notation = notation;
        this.descriptionRestaurant = descriptionRestaurant;
        this.menu = menu;
    }
}

export class Restaurateur extends Compte {


    constructor(id?:number, nom?: string, prenom?: string, mail?: string, mdp?: string, adresse?:Adresse) {
    super(id, nom, prenom, mail, mdp, adresse);
    }
} 


