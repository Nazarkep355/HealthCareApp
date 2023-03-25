import { Box, Grid, Typography } from '@mui/material';
import { FC, useState } from 'react';
import { map } from 'lodash'
import Card, { ICardItemProps } from './Card';
import RegisterToDoctor, { IRegisterToDoctorProps } from '../ModalWidows/RegisterToDoctor';
import { JsxElement } from 'typescript';

interface IPopupCardProps {
	modalWindow: JsxElement;
}
interface ICardListProps {
	title: string;
	cards: ICardItemProps[];
	onCardClick?: (id: number) =>void;
}

const CardList: FC<ICardListProps> = (props) => {
	return (
			<>
				<Box
					display="flex"
					alignItems="center"
					justifyContent="space-between"
					sx={{
						pb: 3
					}}
				>
					<Typography variant="h3">{props.title}</Typography>
				</Box>
				<Grid container spacing={3}>
					{map(props.cards, (card) => {
						return <Card {...card} key={card.title} handleClick={props.onCardClick}/>;
					})}
				</Grid>
		</>
	);
};

export default CardList;