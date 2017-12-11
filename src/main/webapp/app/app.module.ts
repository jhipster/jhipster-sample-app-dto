import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ngx-webstorage';

import { JhipsterDtoSampleApplicationSharedModule, UserRouteAccessService } from './shared';
import { JhipsterDtoSampleApplicationAppRoutingModule} from './app-routing.module';
import { JhipsterDtoSampleApplicationHomeModule } from './home/home.module';
import { JhipsterDtoSampleApplicationAdminModule } from './admin/admin.module';
import { JhipsterDtoSampleApplicationAccountModule } from './account/account.module';
import { JhipsterDtoSampleApplicationEntityModule } from './entities/entity.module';
import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

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
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-'}),
        JhipsterDtoSampleApplicationSharedModule,
        JhipsterDtoSampleApplicationHomeModule,
        JhipsterDtoSampleApplicationAdminModule,
        JhipsterDtoSampleApplicationAccountModule,
        JhipsterDtoSampleApplicationEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [ JhiMainComponent ]
})
export class JhipsterDtoSampleApplicationAppModule {}
