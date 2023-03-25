import { useRoutes } from 'react-router-dom';
import router from 'src/router';

import LocalizationProvider from '@mui/lab/LocalizationProvider';
import { AdapterMoment } from '@mui/x-date-pickers/AdapterMoment';
import { CssBaseline } from '@mui/material';
import ThemeProvider from './theme/ThemeProvider';
import './globalStyles/index.scss'
import { QueryClient, QueryClientProvider } from 'react-query';

function App() {
  const content = useRoutes(router);
  const queryClient = new QueryClient();
  return (
    <QueryClientProvider client={queryClient}>
      <ThemeProvider>
        <LocalizationProvider dateAdapter={AdapterMoment}>
          <CssBaseline />
          {content}
        </LocalizationProvider>
      </ThemeProvider>
    </QueryClientProvider>
  );
}
export default App;
