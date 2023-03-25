import { each } from 'lodash';
import Doctor from './Doctor';
import MedicalTopic from './MedicalTopic';
import User from './User';

export interface IDoctorRecordServerModel {
  id: number;
  patient: User;
  doctor: Doctor;
  topic: MedicalTopic;
  date: number;
}

export default class DoctorRecord implements IDoctorRecordServerModel {

  constructor(model?: IDoctorRecordServerModel) {
    if (model) {
      const root = this;
      each(root, (value, key) => {
        root[key] = model[key];
      });
    }
  }
  public patient: User = null;
  public doctor: Doctor = null;
  public date: number = null;
  public id: number = null;
  public topic: MedicalTopic = null;
}