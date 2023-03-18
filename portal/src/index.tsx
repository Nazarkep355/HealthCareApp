import ReactDOM from 'react-dom';
import { HelmetProvider } from 'react-helmet-async';
import { BrowserRouter } from 'react-router-dom';

import 'nprogress/nprogress.css';
import App from 'src/App';
import { SidebarProvider } from 'src/contexts/SidebarContext';
import * as serviceWorker from 'src/serviceWorker';
import { Provider } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import { reduxStore, persistor } from './Store/configureStore';

ReactDOM.render(
  <Provider store={reduxStore}>
    <PersistGate  loading={null} persistor={persistor}>
      <HelmetProvider>
        <SidebarProvider>
          <BrowserRouter>
            <App />
          </BrowserRouter>
        </SidebarProvider>
      </HelmetProvider>
   </PersistGate>
  </Provider>,
  document.getElementById('root')
);
serviceWorker.unregister();
