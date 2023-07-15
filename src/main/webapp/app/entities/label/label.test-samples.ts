import { ILabel, NewLabel } from './label.model';

export const sampleWithRequiredData: ILabel = {
  id: 47569,
  label: 'calculating Switzerland Soft',
};

export const sampleWithPartialData: ILabel = {
  id: 21976,
  label: 'Bedfordshire Steel Gasoline',
};

export const sampleWithFullData: ILabel = {
  id: 58252,
  label: 'Coordinator',
};

export const sampleWithNewData: NewLabel = {
  label: 'heavily Idaho Berkshire',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
