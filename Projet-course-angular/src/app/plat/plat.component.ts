import { Component } from '@angular/core';
import { Plat } from '../model';
import { PlatHttpService } from './plat-http.service';

@Component({
  selector: 'app-plat',
  templateUrl: './plat.component.html',
  styleUrls: ['./plat.component.scss']
})
export class PlatComponent {

  formPlat: Plat=null;

  constructor(private platService: PlatHttpService) {
  }

  listPlat(): Array<Plat> {
    return this.platService.findAll();
  }

  add():void {
    this.formPlat = new Plat();
  }

  edit(id: number): void {
    this.platService.findById(id).subscribe(resp => {
      this.formPlat = resp;
    });
  }

  save(): void {
    if(this.formPlat.id) { // UPDATE
      this.platService.update(this.formPlat);
    } else { // CREATE
      this.platService.create(this.formPlat);
    }

    this.cancel();
  }

  cancel(): void {
    this.formPlat = null;
  }

  remove(id: number): void {
    this.platService.remove(id);
  }

}
