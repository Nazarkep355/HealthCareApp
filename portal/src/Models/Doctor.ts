import { each } from 'lodash';
import MedicalTopic from './MedicalTopic';
import User from './User';

export interface IDoctorServerModel {
  id: number;
  user: User;
  medicalTopic: MedicalTopic;
}

export default class Doctor implements IDoctorServerModel {

  constructor(model?: IDoctorServerModel) {
    if (model) {
      const root = this;
      each(root, (value, key) => {
        root[key] = model[key];
      });
    }
  }
  public id: number = null;
  public user: User = null;
  public  medicalTopic: MedicalTopic = null;
}