import React from 'react';
import { Link as RouterLink } from 'react-router-dom';
import {
    Hidden,
    IconButton,
    Typography,
    Toolbar,
    Box
} from '@mui/material';
import WestIcon from '@mui/icons-material/West';


export const ToolbarProfile = () => {

    return (
        <>
            <Hidden mdUp>
                <Box position='fixed' bgcolor={'default'} sx={{
                    zIndex: '99',
                    top: '0',
                }}>
                    <Toolbar >
                        <RouterLink to={'/home'}>
                            <IconButton color='gray'>
                                <WestIcon />
                            </IconButton>
                        </RouterLink>
                        <Box ml={2}>
                            <Typography variant='h6'>User</Typography>
                            <Typography>N Tweets</Typography>
                        </Box>
                    </Toolbar>
                </Box>
            </Hidden >

            <Hidden mdDown>
                <Box position='fixed' bgcolor={'default'} sx={{
                    width: '40%',
                    maxWidth: "470px",
                    marginLeft: '-20px',
                    zIndex: '99',
                    top: '0',
                }}>
                    <Toolbar>
                        <RouterLink to={'/home'}>
                            <IconButton color='gray' >
                                <WestIcon />
                            </IconButton>
                        </RouterLink>
                        <Box ml={2}>
                            <Typography variant='h6'>User</Typography>
                            <Typography>N Tweets</Typography>
                        </Box>
                    </Toolbar>
                </Box>
            </Hidden>           
        </>
    )
}

export default ToolbarProfile