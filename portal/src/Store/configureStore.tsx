import { configureStore } from '@reduxjs/toolkit';

import rootReducer from '../reducers';

const reduxStore = configureStore({
	reducer: rootReducer,
	devTools: process.env.NODE_ENV !== 'production',
	middleware: (getDefaultMiddleware) =>
		getDefaultMiddleware({
			serializableCheck: false
		})
});

export default reduxStore;