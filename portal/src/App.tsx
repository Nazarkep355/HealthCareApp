import { useRoutes } from 'react-router-dom';
import router from 'src/router';

import AdapterDateFns from '@mui/lab/AdapterDateFns';
import LocalizationProvider from '@mui/lab/LocalizationProvider';

import { CssBaseline } from '@mui/material';
import ThemeProvider from './theme/ThemeProvider';
import { Provider } from 'react-redux';
import reduxStore from './Store/configureStore';
import './globalStyles/index.scss'

function App() {
  const content = useRoutes(router);

  return (
    <Provider store={reduxStore}>
      <ThemeProvider>
        <LocalizationProvider dateAdapter={AdapterDateFns}>
          <CssBaseline />
          {content}
        </LocalizationProvider>
      </ThemeProvider>
    </Provider>
  );
}
export default App;
