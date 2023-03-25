import { Button, DialogActions, DialogContentText, Grid, MenuItem, Select, TextField } from '@mui/material';
import moment from 'moment';
import {isEmpty} from 'lodash';
import {FC, useState} from 'react';
import Doctor from 'src/models/Doctor';
import ModalWrapper, { CloseType, IModalWindowProps } from './ModalWrapper';
import DoctorRecord from 'src/models/DoctorRecord';
export interface IDoctorRecordResultProps extends IModalWindowProps {
}

const DoctorRecordResult: FC<IDoctorRecordResultProps> = (props) => {
    const [record, setRecord] = useState<DoctorRecord>(props.data as DoctorRecord);
    const handleClose = () => {
        props.handleClose(CloseType.CLOSE, null)
    };
    const handleSubmit= () => {
        props.handleClose(CloseType.OK, null)
    };
    return (
        <div>
            <DialogContentText style={{marginBottom: '8px'}}>
                Дані про візит до {record.doctor.user.firstName + ' ' + record.doctor.user.secondName}
            </DialogContentText>
            <Grid
                container
                direction="column"
                spacing={'4'}
            >
                <Grid item >
                    <DialogContentText style={{marginBottom: '8px'}}>
                       тут повинен бути результат
                    </DialogContentText>
                </Grid>
            </Grid>
            <DialogActions>
				<Button onClick={handleClose}>OK</Button>
			</DialogActions>
        </div>
    );
};

export default ModalWrapper(DoctorRecordResult);
