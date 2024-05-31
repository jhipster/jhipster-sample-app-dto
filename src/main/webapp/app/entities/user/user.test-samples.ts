import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 32243,
  login: 'W={GB@p',
};

export const sampleWithPartialData: IUser = {
  id: 25743,
  login: 'qErq',
};

export const sampleWithFullData: IUser = {
  id: 31625,
  login: 'f.z0VW',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
