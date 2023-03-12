import { FC } from 'react';
import { QueryClient, QueryClientProvider } from 'react-query';
import LoginForm from '../LoginForm/LogintForm';

const App: FC = () => {
    const queryClient = new QueryClient()
    return (
        <QueryClientProvider client={queryClient}>
            <div className='mainPageContainer'>
                <LoginForm/>
            </div>
        </QueryClientProvider>
    );
};

export default App;