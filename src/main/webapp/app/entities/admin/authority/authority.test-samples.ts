import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '4f124acb-8da8-4a5d-bee6-1a6f853ed95a',
};

export const sampleWithPartialData: IAuthority = {
  name: '100b7600-7d0b-43b2-b994-51357d007396',
};

export const sampleWithFullData: IAuthority = {
  name: '7df26a83-3e1a-43de-998a-4405db6b6992',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
