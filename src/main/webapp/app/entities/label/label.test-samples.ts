import { ILabel, NewLabel } from './label.model';

export const sampleWithRequiredData: ILabel = {
  id: 9201,
  label: 'yahoo whoa athwart',
};

export const sampleWithPartialData: ILabel = {
  id: 13354,
  label: 'phew consequently eek',
};

export const sampleWithFullData: ILabel = {
  id: 31388,
  label: 'indeed smug blissful',
};

export const sampleWithNewData: NewLabel = {
  label: 'till against constant',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
