import { FC, useState } from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';

import './loginForm.scss'
import { GetUser } from '../../Services/UserServise';

const LoginForm: FC = () => {
	const [email, setEmail] = useState<string>(null);
	const [password, setPassword] = useState<string>(null);

	const login = async (): Promise<void> => {
		const a = await GetUser(email, password);
		console.log(a);
	};

	return(
		<div className='loginContainer'>
			<Container component="main" maxWidth="xs">
				<p className='title'>Система медичного догляду</p>
				<Box
					sx={{
						marginTop: 8,
						display: 'flex',
						flexDirection: 'column',
						alignItems: 'center',
						margin: '0'
					}}
				>
					<Box>
						<TextField
							margin="normal"
							required
							fullWidth
							id="email"
							label="Пошта"
							name="email"
							autoComplete="email"
							autoFocus
							onChange={(val) => setEmail(val.target.value)}
						/>
						<TextField
							margin="normal"
							required
							fullWidth
							name="password"
							label="Пароль"
							type="password"
							id="password"
							autoComplete="current-password"
							onChange={(val) => setPassword(val.target.value)}
						/>
						<FormControlLabel
							control={<Checkbox value="remember" color="primary" />}
							label="Запам'ятати мене"
						/>
						<Button
							type="submit"
							fullWidth
							variant="contained"
							sx={{ mt: 3, mb: 2 }}
							onClick={login}
						>
							Увійти
						</Button>
					</Box>
				</Box>
			</Container>
		</div>
	);
};

export default LoginForm;
