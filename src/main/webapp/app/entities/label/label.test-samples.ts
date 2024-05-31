import { ILabel, NewLabel } from './label.model';

export const sampleWithRequiredData: ILabel = {
  id: 15587,
  label: 'suddenly decrease bah',
};

export const sampleWithPartialData: ILabel = {
  id: 16706,
  label: 'aha notwithstanding',
};

export const sampleWithFullData: ILabel = {
  id: 13033,
  label: 'whereas repulse',
};

export const sampleWithNewData: NewLabel = {
  label: 'indeed',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
