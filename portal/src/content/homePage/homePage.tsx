import { Container, Grid } from '@mui/material';
import { FC } from 'react';
import { Helmet } from 'react-helmet-async';
import { ICardItemProps } from 'src/components/Card/Card';
import CardList from 'src/components/Card/CardList';
import Footer from 'src/components/Footer';
import PageTitleWrapper from 'src/components/PageTitleWrapper';
import PageHeader from '../dashboards/Crypto/PageHeader';

const mockData: ICardItemProps[] = [
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 1",
		subtitle: "Mock Subtitle 1"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 2",
		subtitle: "Mock Subtitle 2"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 3",
		subtitle: "Mock Subtitle 3"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 4",
		subtitle: "Mock Subtitle 4"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 5",
		subtitle: "Mock Subtitle 5"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 6",
		subtitle: "Mock Subtitle 6"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
tooltip: "Записатися",
		title: "Mock Title 7",
		subtitle: "Mock Subtitle 7"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 8",
		subtitle: "Mock Subtitle 8"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 9",
		subtitle: "Mock Subtitle 9"
	},
	{
		avatar: "/static/images/avatars/4.jpg",
        tooltip: "Записатися",
		title: "Mock Title 10",
		subtitle: "Mock Subtitle 10"
	}
];
const HomePage: FC = () => {
    return (
        <>
            <Helmet>
                <title>Головна</title>
            </Helmet>
            <PageTitleWrapper>
                <PageHeader />
            </PageTitleWrapper>
            <Container maxWidth="lg">
                <Grid
                    container
                    direction="row"
                    justifyContent="center"
                    alignItems="stretch"
                    spacing={4}
                >
                    <Grid item xs={12}>
                        <CardList title={'Лікарі'} cards={mockData} />
                    </Grid>
                    <Grid item xs={12}>
                        <CardList title={'Аналізи'} cards={mockData} />
                    </Grid>
                </Grid>
            </Container>
            <Footer />
        </>
    )
}

export default HomePage;