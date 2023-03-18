import { Box, Grid, Typography } from '@mui/material';
import { FC } from 'react';
import { map } from 'lodash'
import Card, { ICardItemProps } from './Card';

interface ICardListProps {
    title: string;
    cards: ICardItemProps[];
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
                return <Card {...card} key={card.title}/>;
          })}
        </Grid>
      </>
    );
};

export default CardList;