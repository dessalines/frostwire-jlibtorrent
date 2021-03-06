
%{
#include "session_extend.h"
%}

namespace libtorrent {

class upnp;

%extend session {

    void add_lt_trackers_extension() {
        $self->add_extension(&libtorrent::create_lt_trackers_plugin);
    }

    void add_smart_ban_extension() {
         $self->add_extension(&libtorrent::create_smart_ban_plugin);
    }

    void dht_get_item(std::vector<char>& key_v, std::string salt = std::string()) {
        boost::array<char, 32> key;

        for (int i = 0; i < 32; i++) {
            key[i] = key_v[i];
        }

        $self->dht_get_item(key, salt);
    }

    void dht_put_item(std::vector<char>& public_key, std::vector<char>& private_key, entry& data, std::string salt = std::string()) {
        if (public_key.size() != 32) {
            throw std::invalid_argument("Public key must be of size 32");
        }
        if (private_key.size() != 64) {
            throw std::invalid_argument("Private key must be of size 64");
        }
        boost::array<char, 32> key;

    	for (int i = 0; i < 32; i++) {
    	    key[i] = public_key[i];
    	}

        $self->dht_put_item(key, boost::bind(&dht_put_item_cb, _1, _2, _3, _4,
            public_key.data(), private_key.data(), data), salt);
    }

    void dht_get_peers(sha1_hash const& info_hash) {
        dht_get_peers($self, info_hash);
    }

    void dht_announce(sha1_hash const& info_hash, int port, int flags) {
        dht_announce($self, info_hash, port, flags);
    }

    void dht_announce(sha1_hash const& info_hash) {
        dht_announce($self, info_hash);
    }

    void set_piece_hashes(std::string const& id, libtorrent::create_torrent& t, std::string const& p, error_code& ec) {
        set_piece_hashes($self, id, t, p, ec);
    }

    upnp* get_upnp() {
        return get_upnp($self);
    }

    void add_swig_extension(swig_plugin *p) {
        $self->add_extension(boost::shared_ptr<plugin>(p));
    }
};

}

%feature("director") swig_plugin;
%feature("director") swig_torrent_plugin;
%feature("director") swig_peer_plugin;

%typemap("javapackage") SwigPlugin, SwigPlugin *, SwigPlugin & "com.frostwire.jlibtorrent.plugins";

%ignore swig_plugin::new_torrent(torrent*, void*);
%ignore swig_plugin::added(aux::session_impl*);

%ignore swig_torrent_plugin::new_connection;

%ignore swig_peer_plugin::on_extended;
%ignore swig_peer_plugin::on_unknown_message;

%include "session_plugins.h"
