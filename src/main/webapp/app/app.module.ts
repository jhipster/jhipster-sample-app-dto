import './vendor.ts';

import { NgModule, Injector } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Ng2Webstorage } from 'ngx-webstorage';
import { JhiEventManager } from 'ng-jhipster';

import { AuthExpiredInterceptor } from './blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from './blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from './blocks/interceptor/notification.interceptor';
import { JhipsterDtoSampleApplicationSharedModule } from 'app/shared';
import { JhipsterDtoSampleApplicationCoreModule } from 'app/core';
import { JhipsterDtoSampleApplicationAppRoutingModule } from './app-routing.module';
import { JhipsterDtoSampleApplicationHomeModule } from './home/home.module';
import { JhipsterDtoSampleApplicationAccountModule } from './account/account.module';
import { JhipsterDtoSampleApplicationEntityModule } from './entities/entity.module';
import { PaginationConfig } from './blocks/config/uib-pagination.config';
import { StateStorageService } from 'app/core/auth/state-storage.service';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import {
  JhiMainComponent,
  NavbarComponent,
  FooterComponent,
  ProfileService,
  PageRibbonComponent,
  ActiveMenuDirective,
  ErrorComponent
} from './layouts';

@NgModule({
  imports: [
    BrowserModule,
    JhipsterDtoSampleApplicationAppRoutingModule,
    Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-' }),
    JhipsterDtoSampleApplicationSharedModule,
    JhipsterDtoSampleApplicationCoreModule,
    JhipsterDtoSampleApplicationHomeModule,
    JhipsterDtoSampleApplicationAccountModule,
    JhipsterDtoSampleApplicationEntityModule
    // jhipster-needle-angular-add-module JHipster will add new module here
  ],
  declarations: [JhiMainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
  providers: [
    ProfileService,
    PaginationConfig,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthExpiredInterceptor,
      multi: true,
      deps: [StateStorageService, Injector]
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorHandlerInterceptor,
      multi: true,
      deps: [JhiEventManager]
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: NotificationInterceptor,
      multi: true,
      deps: [Injector]
    }
  ],
  bootstrap: [JhiMainComponent]
})
export class JhipsterDtoSampleApplicationAppModule {}
