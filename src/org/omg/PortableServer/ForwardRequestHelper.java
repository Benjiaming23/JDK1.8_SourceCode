package org.omg.PortableServer;


/**
* org/omg/PortableServer/ForwardRequestHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u45/3457/corba/src/share/classes/org/omg/PortableServer/poa.idl
* Friday, April 10, 2015 10:49:22 AM PDT
*/

abstract public class ForwardRequestHelper
{
  private static String  _id = "IDL:omg.org/PortableServer/ForwardRequest:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.PortableServer.ForwardRequest that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.PortableServer.ForwardRequest extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ObjectHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "forward_reference",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (org.omg.PortableServer.ForwardRequestHelper.id (), "ForwardRequest", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.PortableServer.ForwardRequest read (org.omg.CORBA.portable.InputStream istream)
  {
    org.omg.PortableServer.ForwardRequest value = new org.omg.PortableServer.ForwardRequest ();
    // read and discard the repository ID
    istream.read_string ();
    value.forward_reference = org.omg.CORBA.ObjectHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.PortableServer.ForwardRequest value)
  {
    // write the repository ID
    ostream.write_string (id ());
    org.omg.CORBA.ObjectHelper.write (ostream, value.forward_reference);
  }

}
