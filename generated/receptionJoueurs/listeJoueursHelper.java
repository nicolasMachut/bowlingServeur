// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `receptionJoueurs.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package receptionJoueurs;

public final class listeJoueursHelper
{
    public static void
    write(IceInternal.BasicStream __os, JoueurSlice[] __v)
    {
        if(__v == null)
        {
            __os.writeSize(0);
        }
        else
        {
            __os.writeSize(__v.length);
            for(int __i0 = 0; __i0 < __v.length; __i0++)
            {
                __os.writeObject(__v[__i0]);
            }
        }
    }

    public static JoueurSlice[]
    read(IceInternal.BasicStream __is)
    {
        JoueurSlice[] __v;
        final int __len0 = __is.readAndCheckSeqSize(1);
        final String __type0 = JoueurSlice.ice_staticId();
        __v = new JoueurSlice[__len0];
        for(int __i0 = 0; __i0 < __len0; __i0++)
        {
            __is.readObject(new IceInternal.SequencePatcher(__v, JoueurSlice.class, __type0, __i0));
        }
        return __v;
    }
}
