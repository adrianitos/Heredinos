package project.factory;

import project.vo.*;

/**
 * Our Factory class.
 */
public class HeredinFactory
{
  public static Object getObject(String criteria)
  {
    if ( criteria.equals("user") )
      return new UserVO();
    else if ( criteria.equals("persona") )
      return new PersonaVO();
    else if ( criteria.equals("cartera") )
      return new CarteraVO();

    return null;
  }
}