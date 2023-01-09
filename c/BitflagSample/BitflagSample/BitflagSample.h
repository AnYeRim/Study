#ifndef ___BitflagSample_h___
# define ___BitflagSample_h___

enum FLAG_TYPE
{
	FLAG_GENERAL_CHECKBOX_RECENT_DESTINATION=0,
	FLAG_GENERAL_CHECKBOX_AUTO_RETURN,
	FLAG_GENERAL_CHECKBOX_HIPASS_POPUP,
	FLAG_ROUTE_CHECKBOX_DESTINATION_DIRECTION,
	FLAG_MAP_CHECKBOX_AUTO_SCALE,
	FLAG_GUIDANCE_CHECKBOX_LANE_GUIDE,
	FLAG_MAP_CHECKBOX_SPEED_VISIBLE,
	FLAG_MAP_CHECKBOX_ASSISTANT_TBT_VISIBLE,
	FLAG_MAX
};

int		m_flag[FLAG_MAX];

bool    getCheckBit();
void    testBit1();
void    testBit2();

#endif