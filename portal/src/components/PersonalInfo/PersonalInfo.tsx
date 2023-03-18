import { Feed } from '@mui/icons-material';
import { Container, Grid } from '@mui/material';
import { FC } from 'react';
import { Helmet } from 'react-helmet-async';
import Addresses from 'src/content/applications/Users/profile/Addresses';
import MyCards from 'src/content/applications/Users/profile/MyCards';
import PopularTags from 'src/content/applications/Users/profile/PopularTags';
import ProfileCover from 'src/content/applications/Users/profile/ProfileCover';
import RecentActivity from 'src/content/applications/Users/profile/RecentActivity';
import Footer from '../Footer';

interface IPersonalInfoProps {
	personId: number;
};


const PersonalInfo: FC<IPersonalInfoProps> = (props) => {
	const user = {
		savedCards: 7,
		name: 'Catherine Pike',
		coverImg: '/static/images/placeholders/covers/5.jpg',
		avatar: '/static/images/avatars/4.jpg',
		description:
		  "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage",
		jobtitle: 'Web Developer',
		location: 'Barcelona, Spain',
		followers: '465'
	};
	
	return (
		<>
			<Helmet>
				<title>HUI</title>
			</Helmet>
			<Container sx={{ mt: 3 }} maxWidth="lg">
				<Grid
					container
					direction="row"
					justifyContent="center"
					alignItems="stretch"
					spacing={3}
				>
					<Grid item xs={12} md={8}>
						<ProfileCover user={user} />
					</Grid>
					<Grid item xs={12} md={4}>
						<RecentActivity />
					</Grid>
					<Grid item xs={12} md={8}>
						<Feed />
					</Grid>
					<Grid item xs={12} md={4}>
						<PopularTags />
					</Grid>
					<Grid item xs={12} md={7}>
						<MyCards />
					</Grid>
					<Grid item xs={12} md={5}>
						<Addresses />
					</Grid>
				</Grid>
				</Container>
			<Footer />
		</>
	);
}

export default PersonalInfo;