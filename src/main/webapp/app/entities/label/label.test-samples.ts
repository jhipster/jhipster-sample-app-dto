import { ILabel, NewLabel } from './label.model';

export const sampleWithRequiredData: ILabel = {
  id: 15587,
  label: 'calculating Cambridgeshire Soft',
};

export const sampleWithPartialData: ILabel = {
  id: 7201,
  label: 'South Steel Gasoline',
};

export const sampleWithFullData: ILabel = {
  id: 19088,
  label: 'Technician',
};

export const sampleWithNewData: NewLabel = {
  label: 'projection embrace',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
