import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 16068,
  login: 'y',
};

export const sampleWithPartialData: IUser = {
  id: 24575,
  login: 'M',
};

export const sampleWithFullData: IUser = {
  id: 13690,
  login: 'aU@Knpnu\\4nJU1UG\\Z9\\69\\GXVAf\\yI',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
