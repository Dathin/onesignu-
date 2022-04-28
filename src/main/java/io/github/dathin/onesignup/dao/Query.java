package io.github.dathin.onesignup.dao;

public interface Query<REQ, RES> {

    RES query(REQ t);

}
